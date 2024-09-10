
-- Insert data into the Package table
INSERT INTO package(id,data_value) VALUES (1,4.00), (2,10.00), (3,20.00), (4,50.00);

-- Insert data into the Duration table
INSERT INTO duration(id,duration_days, description) VALUES
                                                       (1,24, '24 Hours'),
                                                       (2,7, '7 Days'),
                                                       (3,1, '1 Month');

-- Insert data into the Rates table
INSERT INTO rate(id,data_id, duration_id, rate) VALUES
                                                     (
                                                         1,
                                                         (SELECT id FROM Package WHERE data_value = 4),
                                                         (SELECT id FROM Duration WHERE duration_days = 24),
                                                         72.00
                                                     ),
                                                     (
                                                         2,
                                                         (SELECT id FROM Package WHERE data_value = 4),
                                                         (SELECT id FROM Duration WHERE duration_days = 7),
                                                         96.00
                                                     ),
                                                     (
                                                         3,
                                                         (SELECT id FROM Package WHERE data_value = 4),
                                                         (SELECT id FROM Duration WHERE duration_days = 1),
                                                         120.00
                                                     ),
                                                     (
                                                         4,
                                                         (SELECT id FROM Package WHERE data_value = 10),
                                                         (SELECT id FROM Duration WHERE duration_days = 24),
                                                         270.00
                                                     ),
                                                     (
                                                         5,
                                                         (SELECT id FROM Package WHERE data_value = 10),
                                                         (SELECT id FROM Duration WHERE duration_days = 7),
                                                         386.00
                                                     ),
                                                     (
                                                         6,
                                                         (SELECT id FROM Package WHERE data_value = 10),
                                                         (SELECT id FROM Duration WHERE duration_days = 1),
                                                         480.00
                                                     ),
                                                     (
                                                         7,
                                                         (SELECT id FROM Package WHERE data_value = 20),
                                                         (SELECT id FROM Duration WHERE duration_days = 24),
                                                         420.00
                                                     ),
                                                     (
                                                         8,
                                                         (SELECT id FROM Package WHERE data_value = 20),
                                                         (SELECT id FROM Duration WHERE duration_days = 7),
                                                         626.00
                                                     ),
                                                     (
                                                         9,
                                                         (SELECT id FROM Package WHERE data_value = 20),
                                                         (SELECT id FROM Duration WHERE duration_days = 1),
                                                         840.00
                                                     ),
                                                     (
                                                         10,
                                                         (SELECT id FROM Package WHERE data_value = 50),
                                                         (SELECT id FROM Duration WHERE duration_days = 24),
                                                         720.00
                                                     ),
                                                     (
                                                         11,
                                                         (SELECT id FROM Package WHERE data_value = 50),
                                                         (SELECT id FROM Duration WHERE duration_days = 7),
                                                         1206.00
                                                     ),
                                                     (
                                                         12,
                                                         (SELECT id FROM Package WHERE data_value = 50),
                                                         (SELECT id FROM Duration WHERE duration_days = 1),
                                                         1680.00
                                                     );
