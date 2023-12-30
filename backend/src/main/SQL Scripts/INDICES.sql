CREATE INDEX username_idx ON user_account (username);
CREATE INDEX account_id_idx ON notificiation (account_id);
CREATE INDEX shelter_id_idx ON manages (shelter_id);
CREATE INDEX shelter_id_idx ON works_at (shelter_id);
CREATE INDEX species_breed_idx ON pet (species, breed);
CREATE INDEX pet_id_idx ON pet_doc (pet_id);
CREATE INDEX shelter_id_idx ON sheltered_at (shelter_id);
CREATE INDEX shelter_id_idx ON adoption_application_open (shelter_id);
CREATE INDEX shelter_id_idx ON adoption_application_closed (shelter_id);
CREATE INDEX adopter_id_idx ON adopted_by (adopter_id);