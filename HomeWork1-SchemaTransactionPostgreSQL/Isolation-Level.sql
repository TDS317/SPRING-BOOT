-- ===========================================
-- 🛠️ SETUP: Create computers table and data
-- ===========================================

DROP TABLE IF EXISTS computers;

CREATE TABLE computers (
    id SERIAL PRIMARY KEY,
    hostname TEXT NOT NULL,
    owner TEXT
);

-- Insert initial data
INSERT INTO computers (hostname, owner)
VALUES ('comp-01', 'IT Department');


-- ===========================================
-- 🔍 DEMO 1: READ COMMITTED
-- Goal: Show that non-repeatable reads are possible
-- ===========================================

-- 🖥️ SESSION A:
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- Read initial value
SELECT * FROM computers WHERE hostname = 'comp-01';
-- Expect: owner = 'IT Department'

-- Leave this session open here...

--  SESSION B:
-- While SESSION A is still open and uncommitted
UPDATE computers
SET owner = 'DevOps Team'
WHERE hostname = 'comp-01';
COMMIT;

--  Back to SESSION A:
-- Read again — will see updated value
SELECT * FROM computers WHERE hostname = 'comp-01';
-- Expect: owner = 'DevOps Team' (non-repeatable read)

COMMIT;


-- ===========================================
-- DEMO 2: REPEATABLE READ
-- Goal: Show that repeated SELECT sees the same value
-- ===========================================

-- SESSION A:
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- Read initial value
SELECT * FROM computers WHERE hostname = 'comp-01';
-- Expect: owner = 'DevOps Team' (from previous test)

-- Keep session open...

--  SESSION B:
-- Make a concurrent update
UPDATE computers
SET owner = 'Security Team'
WHERE hostname = 'comp-01';
COMMIT;

--  Back to SESSION A:
-- Read again — still sees the old value
SELECT * FROM computers WHERE hostname = 'comp-01';
-- Expect: owner = 'DevOps Team' (repeatable read)

COMMIT;

-- ===========================================
-- DEMO 3: SERIALIZABLE
-- Goal: Only one of two conflicting transactions can commit
-- ===========================================

--  SESSION A:
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- Read the current owner
SELECT * FROM computers WHERE hostname = 'comp-01';
-- Expect: owner = 'Security Team'

-- Keep this session open...

--  SESSION B:
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- Try to update
UPDATE computers
SET owner = 'QA Team'
WHERE hostname = 'comp-01';
COMMIT;

--  Back to SESSION A:
-- Try to also update
UPDATE computers
SET owner = 'AI Lab'
WHERE hostname = 'comp-01';

-- This COMMIT will fail with:
-- ERROR: could not serialize access due to read/write dependencies among transactions
COMMIT;

