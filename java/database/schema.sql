BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar,
	last_name varchar,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE brewery(brewery_id SERIAL NOT NULL PRIMARY KEY, name VARCHAR, user_id int NOT NULL, 
                     phone_num int, address_1 VARCHAR, address_2 VARCHAR, city VARCHAR, state VARCHAR,
                     zip VARCHAR NOT NULL, hours VARCHAR, brewery_img_url VARCHAR, brewery_history VARCHAR, 
                     longitude NUMERIC, latitude NUMERIC, is_active BOOL, been_removed BOOL);
CREATE TABLE beer(beer_id SERIAL NOT NULL PRIMARY KEY, name VARCHAR, img_url VARCHAR,
                  description VARCHAR, abv DECIMAL, beer_type VARCHAR, brewery_id int NOT NULL, been_removed BOOL);
                  
CREATE TABLE reviews(review_id SERIAL NOT NULL PRIMARY KEY, rating int, review VARCHAR, user_id int NOT NULL , brewery_id int NOT NULL , beer_id int NOT NULL );
CREATE TABLE events(event_id SERIAL NOT NULL PRIMARY KEY, event_date date, event_time time with time zone, brewery_id int NOT NULL , description VARCHAR);
CREATE TABLE news(news_id SERIAL NOT NULL PRIMARY KEY, description VARCHAR, brewery_id int NOT NULL );
CREATE TABLE alerts(alert_id SERIAL NOT NULL PRIMARY KEY, brewery_id int NOT NULL, description VARCHAR);
CREATE TABLE response(response_id SERIAL NOT NULL PRIMARY KEY, review_id int NOT NULL, response VARCHAR, user_id int NOT NULL );

CREATE TABLE user_favorties(user_id int NOT NULL, brewery_id int NOT NULL,
                CONSTRAINT pk_user_favorites PRIMARY KEY(user_id, brewery_id),
                CONSTRAINT fk_user_favorites_brewery FOREIGN KEY(brewery_id) REFERENCES brewery(brewery_id),
                CONSTRAINT fk_user_favorites_user FOREIGN KEY(user_id) REFERENCES users(user_id));
                
CREATE TABLE sold_at(brewery_id int NOT NULL, beer_id int NOT NULL,
                CONSTRAINT pk_sold_at PRIMARY KEY(brewery_id, beer_id),
                CONSTRAINT fk_sold_at_brewery FOREIGN KEY(brewery_id) REFERENCES brewery(brewery_id),
                CONSTRAINT fk_sold_at_beer FOREIGN KEY(beer_id) REFERENCES beer(beer_id));
                
CREATE TABLE user_beer_history(user_id int NOT NULL, beer_id int NOT NULL,
                CONSTRAINT pk_user_beer_history PRIMARY KEY (user_id, beer_id),
                CONSTRAINT fk_user_beer_history_user FOREIGN KEY(user_id) REFERENCES users(user_id),
                CONSTRAINT fk_user_beer_history_beer FOREIGN KEY(beer_id) REFERENCES beer(beer_id));
CREATE TABLE user_brewery_history(user_id int NOT NULL, brewery_id int NOT NULL,
                CONSTRAINT pk_user_brewery_history PRIMARY KEY (user_id, brewery_id),
                CONSTRAINT fk_user_brewery_history_user FOREIGN KEY(user_id) REFERENCES users(user_id),
                CONSTRAINT fk_user_brewery_history_brewery FOREIGN KEY(brewery_id) REFERENCES brewery(brewery_id));
ALTER TABLE brewery
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id);
    
ALTER TABLE beer
    ADD CONSTRAINT fk_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_id);

ALTER TABLE reviews 
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
    ADD CONSTRAINT fk_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_id),
    ADD CONSTRAINT fk_beer_id FOREIGN KEY (beer_id) REFERENCES beer (beer_id);
ALTER TABLE events
    ADD CONSTRAINT fk_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_id);
ALTER TABLE news
    ADD CONSTRAINT fk_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_id);
ALTER TABLE alerts
    ADD CONSTRAINT fk_brewery_id FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_id);
ALTER TABLE response
    ADD CONSTRAINT fk_review_id FOREIGN KEY (review_id) REFERENCES reviews (review_id),
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id);

COMMIT TRANSACTION;
