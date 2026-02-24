CREATE TABLE IF NOT EXISTS tb_workout_plan (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),

    CONSTRAINT fk_workout_plan_user
        FOREIGN KEY (user_id)
        REFERENCES tb_user(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tb_plan_item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    plan_id BIGINT NOT NULL,
    title VARCHAR(120) NOT NULL,
    position INT NOT NULL,

    CONSTRAINT fk_plan_item_plan
        FOREIGN KEY (plan_id)
        REFERENCES tb_workout_plan(id)
        ON DELETE CASCADE
);
