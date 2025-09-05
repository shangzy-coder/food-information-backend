-- 插入测试数据到生产数据库
USE food_information;

-- 插入测试用户
INSERT INTO sys_user (username, password, email, phone, real_name) VALUES
('admin', '$2a$10$7JB720yubVSOfvVWind4Xed6d64uMR.vSRDGxQjaTOqeOHrADX/LW', 'admin@food-info.com', '13800138000', '系统管理员'),
('test', '$2a$10$7JB720yubVSOfvVWind4Xed6d64uMR.vSRDGxQjaTOqeOHrADX/LW', 'test@food-info.com', '13800138001', '测试用户'),
('demo', '$2a$10$7JB720yubVSOfvVWind4Xed6d64uMR.vSRDGxQjaTOqeOHrADX/LW', 'demo@food-info.com', '13800138002', '演示用户');

-- 插入食品分类
INSERT INTO food_category (category_name, category_code, parent_id, level, sort_order, description) VALUES
('水果', 'FRUIT', 0, 1, 1, '新鲜水果类'),
('蔬菜', 'VEGETABLE', 0, 1, 2, '新鲜蔬菜类'),
('肉类', 'MEAT', 0, 1, 3, '肉类及肉制品'),
('乳制品', 'DAIRY', 0, 1, 4, '牛奶及乳制品'),
('谷物', 'GRAIN', 0, 1, 5, '谷物及谷物制品'),
('饮料', 'BEVERAGE', 0, 1, 6, '各类饮料'),
('零食', 'SNACK', 0, 1, 7, '休闲零食'),
('调料', 'SEASONING', 0, 1, 8, '调味料及香料');

-- 插入营养成分
INSERT INTO nutrition_component (component_name, component_code, unit, description, daily_value) VALUES
('热量', 'ENERGY', 'kcal', '食物提供的能量', 2000.00),
('蛋白质', 'PROTEIN', 'g', '构成人体的重要营养素', 50.00),
('脂肪', 'FAT', 'g', '提供能量的营养素', 65.00),
('碳水化合物', 'CARBOHYDRATE', 'g', '主要的能量来源', 300.00),
('膳食纤维', 'FIBER', 'g', '促进消化的营养素', 25.00),
('钠', 'SODIUM', 'mg', '调节体液平衡', 2300.00),
('钙', 'CALCIUM', 'mg', '骨骼和牙齿的重要成分', 1000.00),
('铁', 'IRON', 'mg', '血红蛋白的重要成分', 18.00),
('维生素C', 'VITAMIN_C', 'mg', '抗氧化维生素', 90.00),
('维生素A', 'VITAMIN_A', 'μg', '视觉和免疫系统重要维生素', 900.00);

-- 插入测试食品数据
INSERT INTO food_info (food_name, food_code, category, brand, description, ingredients, allergen_info, storage_condition, shelf_life, manufacturer, origin_country, barcode) VALUES
('红富士苹果', 'APPLE001', '水果', '新鲜果园', '新鲜红富士苹果，口感脆甜', '苹果', '无', '常温保存', '7天', '新鲜果园有限公司', '中国', '6901234567890'),
('有机胡萝卜', 'CARROT001', '蔬菜', '绿色农场', '有机种植胡萝卜，营养丰富', '胡萝卜', '无', '冷藏保存', '14天', '绿色农场合作社', '中国', '6901234567891'),
('优质牛肉', 'BEEF001', '肉类', '草原牧场', '优质草饲牛肉，蛋白质丰富', '牛肉', '无', '冷冻保存', '30天', '草原牧场有限公司', '中国', '6901234567892'),
('纯牛奶', 'MILK001', '乳制品', '阳光牧场', '100%纯牛奶，无添加', '生牛乳', '含乳制品', '冷藏保存', '7天', '阳光牧场乳业', '中国', '6901234567893'),
('有机大米', 'RICE001', '谷物', '金色稻田', '有机种植大米，口感香甜', '大米', '可能含有麸质', '干燥保存', '365天', '金色稻田农业', '中国', '6901234567894'),
('矿泉水', 'WATER001', '饮料', '清泉', '天然矿泉水，富含矿物质', '天然矿泉水', '无', '常温保存', '730天', '清泉饮品有限公司', '中国', '6901234567895');

-- 插入食品营养成分数据
-- 苹果营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(1, 1, 52, '100g'),   -- 热量
(1, 2, 0.3, '100g'),  -- 蛋白质
(1, 3, 0.2, '100g'),  -- 脂肪
(1, 4, 14, '100g'),   -- 碳水化合物
(1, 5, 2.4, '100g'),  -- 膳食纤维
(1, 9, 4.6, '100g');  -- 维生素C

-- 胡萝卜营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(2, 1, 41, '100g'),   -- 热量
(2, 2, 0.9, '100g'),  -- 蛋白质
(2, 3, 0.2, '100g'),  -- 脂肪
(2, 4, 10, '100g'),   -- 碳水化合物
(2, 5, 2.8, '100g'),  -- 膳食纤维
(2, 10, 835, '100g'); -- 维生素A

-- 牛肉营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(3, 1, 250, '100g'),  -- 热量
(3, 2, 26, '100g'),   -- 蛋白质
(3, 3, 15, '100g'),   -- 脂肪
(3, 4, 0, '100g'),    -- 碳水化合物
(3, 8, 2.6, '100g');  -- 铁

-- 牛奶营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(4, 1, 42, '100ml'),  -- 热量
(4, 2, 3.4, '100ml'), -- 蛋白质
(4, 3, 1.0, '100ml'), -- 脂肪
(4, 4, 5.0, '100ml'), -- 碳水化合物
(4, 7, 113, '100ml'); -- 钙

-- 大米营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(5, 1, 130, '100g'),  -- 热量
(5, 2, 2.7, '100g'),  -- 蛋白质
(5, 3, 0.3, '100g'),  -- 脂肪
(5, 4, 28, '100g'),   -- 碳水化合物
(5, 5, 0.4, '100g');  -- 膳食纤维

-- 矿泉水营养成分
INSERT INTO food_nutrition (food_id, component_id, content, per_unit) VALUES
(6, 1, 0, '100ml'),   -- 热量
(6, 2, 0, '100ml'),   -- 蛋白质
(6, 3, 0, '100ml'),   -- 脂肪
(6, 4, 0, '100ml'),   -- 碳水化合物
(6, 6, 5, '100ml');   -- 钠

-- 为测试数据库插入相同的测试数据
USE food_test;

-- 复制用户数据
INSERT INTO sys_user (username, password, email, phone, real_name) 
SELECT username, password, email, phone, real_name FROM food_information.sys_user;

-- 复制分类数据
INSERT INTO food_category (category_name, category_code, parent_id, level, sort_order, description)
SELECT category_name, category_code, parent_id, level, sort_order, description FROM food_information.food_category;

-- 复制营养成分数据
INSERT INTO nutrition_component (component_name, component_code, unit, description, daily_value)
SELECT component_name, component_code, unit, description, daily_value FROM food_information.nutrition_component;

-- 复制食品数据
INSERT INTO food_info (food_name, food_code, category, brand, description, ingredients, allergen_info, storage_condition, shelf_life, manufacturer, origin_country, barcode)
SELECT food_name, food_code, category, brand, description, ingredients, allergen_info, storage_condition, shelf_life, manufacturer, origin_country, barcode FROM food_information.food_info;

-- 复制食品营养成分关联数据
INSERT INTO food_nutrition (food_id, component_id, content, per_unit)
SELECT food_id, component_id, content, per_unit FROM food_information.food_nutrition;