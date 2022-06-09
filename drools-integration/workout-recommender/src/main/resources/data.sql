INSERT INTO authority (name) VALUES ('USER');
INSERT INTO authority (name) VALUES ('ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);  --ROLE USER
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);  --ROLE USER
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 2);  --ROLE ADMIN

INSERT INTO exerciser (id, name, surname, email, enabled, password, activity_level, body_type, age, height, weight) VALUES (1, 'Milica', 'Milic', 'milica@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'VERY_ACTIVE', 'ENDOMORPH', 22, 1.64, 65);
INSERT INTO exerciser (id, name, surname, email, enabled, password, activity_level, body_type, age, height, weight) VALUES (2, 'Milos', 'Mikic', 'milos@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'VERY_ACTIVE', 'ECTOMORPH', 26, 1.84, 82);

INSERT INTO admin (id, name, surname, email, enabled, password) VALUES (3, 'Pera', 'Petrovic', 'admin@mail.com', true, '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra');

INSERT INTO workout (id, name, link, workout_duration, workout_intensity, workout_type) VALUES (1, 'Cardio 1', 'https://www.youtube.com/watch?v=dummy', 45.0, 'HIGH', 'CARDIO');

INSERT INTO workout_equipment (workout_id, equipment) VALUES (1, 'EXPANDER');
INSERT INTO workout_equipment (workout_id, equipment) VALUES (1, 'DUMBBELLS');

INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'NORMAL');
INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'GOOD_HAPPY');
INSERT INTO workout_mood (workout_id, mood) VALUES (1, 'BORED');
