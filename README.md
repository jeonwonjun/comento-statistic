# 1. 데이터베이스 스키마 (MySQL 8)

```
-- 조직(부서)
CREATE TABLE departments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  UNIQUE KEY uk_departments_name (name)
);

-- 사용자
CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  dept_id BIGINT NOT NULL,
  username VARCHAR(100) NOT NULL,
  CONSTRAINT fk_users_dept FOREIGN KEY (dept_id) REFERENCES departments(id)
);

-- 로그인 이벤트(접속 기록)
CREATE TABLE login_events (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  dept_id BIGINT NOT NULL,
  logged_at DATETIME NOT NULL,            -- 원본 타임스탬프
  logged_date DATE GENERATED ALWAYS AS (DATE(logged_at)) STORED,  -- 조회 최적화용
  CONSTRAINT fk_login_user FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_login_dept FOREIGN KEY (dept_id) REFERENCES departments(id),
  INDEX idx_login_events_logged_date (logged_date),
  INDEX idx_login_events_user_logged_date (user_id, logged_date),
  INDEX idx_login_events_dept_logged_date (dept_id, logged_date)
);

-- 공휴일
CREATE TABLE holidays (
  holiday_date DATE PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
CREATE INDEX idx_holidays_date ON holidays (holiday_date);

-- 샘플 데이터(원하면 사용)
INSERT INTO departments(name) VALUES ('HR'), ('Sales'), ('R&D');

INSERT INTO users(dept_id, username) VALUES
  (1, 'alice'), (2, 'bob'), (3, 'charlie'), (2, 'david');

-- 예시: 며칠치 접속
INSERT INTO login_events(user_id, dept_id, logged_at) VALUES
  (1, 1, '2025-09-01 09:11:00'),
  (2, 2, '2025-09-01 10:20:00'),
  (3, 3, '2025-09-02 08:45:00'),
  (2, 2, '2025-09-02 09:00:00'),
  (4, 2, '2025-09-15 15:10:00');

-- 예시: 공휴일 등록
INSERT INTO holidays(holiday_date, name) VALUES
  ('2025-09-14', 'Sample Holiday');

```

## 1-1. ERD
<img width="360" height="360" alt="ERD_comento" src="https://github.com/user-attachments/assets/5c164b80-370b-44cf-b72f-76e273f954ac" />
