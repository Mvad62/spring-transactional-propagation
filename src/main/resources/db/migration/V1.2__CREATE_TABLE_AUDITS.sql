CREATE TABLE IF NOT EXISTS audits
(
    id         BIGSERIAL PRIMARY KEY,
    action     VARCHAR,
    details    VARCHAR,
    created_at TIMESTAMP
);