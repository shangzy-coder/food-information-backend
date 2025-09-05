-- 创建数据库
CREATE DATABASE IF NOT EXISTS food_information CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS food_test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE food_information;

-- 系统用户表
CREATE TABLE IF NOT EXISTS sys_user (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    email VARCHAR(100) COMMENT '邮箱',
    phone VARCHAR(20) COMMENT '手机号',
    real_name VARCHAR(50) COMMENT '真实姓名',
    status TINYINT DEFAULT 1 COMMENT '状态：1-正常，0-禁用',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '系统用户表';

-- 食品信息表
CREATE TABLE IF NOT EXISTS food_info (
    food_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '食品ID',
    food_name VARCHAR(100) NOT NULL COMMENT '食品名称',
    food_code VARCHAR(50) UNIQUE COMMENT '食品编码',
    category VARCHAR(50) COMMENT '食品分类',
    brand VARCHAR(100) COMMENT '品牌',
    description TEXT COMMENT '食品描述',
    nutrition_info JSON COMMENT '营养信息',
    ingredients TEXT COMMENT '配料表',
    allergen_info VARCHAR(500) COMMENT '过敏原信息',
    storage_condition VARCHAR(200) COMMENT '储存条件',
    shelf_life VARCHAR(50) COMMENT '保质期',
    production_date DATE COMMENT '生产日期',
    expiry_date DATE COMMENT '过期日期',
    manufacturer VARCHAR(200) COMMENT '生产厂家',
    origin_country VARCHAR(50) COMMENT '原产国',
    barcode VARCHAR(50) COMMENT '条形码',
    status TINYINT DEFAULT 1 COMMENT '状态：1-正常，0-下架',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '食品信息表';

-- 食品分类表
CREATE TABLE IF NOT EXISTS food_category (
    category_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
    category_name VARCHAR(100) NOT NULL COMMENT '分类名称',
    category_code VARCHAR(50) UNIQUE COMMENT '分类编码',
    parent_id BIGINT DEFAULT 0 COMMENT '父分类ID',
    level TINYINT DEFAULT 1 COMMENT '分类层级',
    sort_order INT DEFAULT 0 COMMENT '排序',
    description TEXT COMMENT '分类描述',
    status TINYINT DEFAULT 1 COMMENT '状态：1-正常，0-禁用',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '食品分类表';

-- 营养成分表
CREATE TABLE IF NOT EXISTS nutrition_component (
    component_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '成分ID',
    component_name VARCHAR(100) NOT NULL COMMENT '成分名称',
    component_code VARCHAR(50) UNIQUE COMMENT '成分编码',
    unit VARCHAR(20) COMMENT '单位',
    description TEXT COMMENT '成分描述',
    daily_value DECIMAL(10,2) COMMENT '每日推荐值',
    status TINYINT DEFAULT 1 COMMENT '状态：1-正常，0-禁用',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '营养成分表';

-- 食品营养成分关联表
CREATE TABLE IF NOT EXISTS food_nutrition (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    food_id BIGINT NOT NULL COMMENT '食品ID',
    component_id BIGINT NOT NULL COMMENT '成分ID',
    content DECIMAL(10,2) COMMENT '含量',
    per_unit VARCHAR(20) DEFAULT '100g' COMMENT '每单位',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    FOREIGN KEY (food_id) REFERENCES food_info(food_id) ON DELETE CASCADE,
    FOREIGN KEY (component_id) REFERENCES nutrition_component(component_id) ON DELETE CASCADE,
    UNIQUE KEY uk_food_component (food_id, component_id)
) COMMENT '食品营养成分关联表';

-- 创建索引
CREATE INDEX idx_food_name ON food_info(food_name);
CREATE INDEX idx_food_category ON food_info(category);
CREATE INDEX idx_food_brand ON food_info(brand);
CREATE INDEX idx_food_barcode ON food_info(barcode);
CREATE INDEX idx_category_parent ON food_category(parent_id);
CREATE INDEX idx_user_username ON sys_user(username);
CREATE INDEX idx_user_email ON sys_user(email);

-- 为测试数据库创建相同的表结构
USE food_test;

-- 复制所有表结构到测试数据库
CREATE TABLE IF NOT EXISTS sys_user LIKE food_information.sys_user;
CREATE TABLE IF NOT EXISTS food_info LIKE food_information.food_info;
CREATE TABLE IF NOT EXISTS food_category LIKE food_information.food_category;
CREATE TABLE IF NOT EXISTS nutrition_component LIKE food_information.nutrition_component;
CREATE TABLE IF NOT EXISTS food_nutrition LIKE food_information.food_nutrition;