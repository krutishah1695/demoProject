DROP TABLE interfaceData IF EXISTS;

CREATE TABLE interfaceData  (
    interface_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
   date_string VARCHAR(20),
    cost_center VARCHAR(20),
    fund_code VARCHAR(20),
    natural_account VARCHAR(20),
    currency VARCHAR(3),
    acc_Info VARCHAR(25),
    type_string  VARCHAR(20),
    number BIGINT,
    glas VARCHAR(4)
    
);

select * from interfaceData;