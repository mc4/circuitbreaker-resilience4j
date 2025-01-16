DROP TABLE IF EXISTS ACTIVITY;

CREATE TABLE ACTIVITY (
	activity_id INTEGER,
	activity VARCHAR2(255),
	availability DOUBLE,
	activity_type VARCHAR(255),
	participants INTEGER,
	price DOUBLE,
	accessibility VARCHAR(255),
	duration VARCHAR(255),
	kid_friendly BOOLEAN,
	link VARCHAR(255),
	activity_key VARCHAR(255)
);