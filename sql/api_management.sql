-- api管理平台sql

-- 接口信息
CREATE TABLE IF NOT EXISTS `api_interface_info`
(
    `id`              BIGINT                             NOT NULL auto_increment COMMENT '主键' PRIMARY KEY,
    `name`            VARCHAR(256)                       NOT NULL COMMENT '名称',
    `description`     VARCHAR(256)                       NULL COMMENT '描述',
    `url`             VARCHAR(512)                       NOT NULL COMMENT '接口地址',
    `request_params`  TEXT                               NOT NULL COMMENT '请求参数',
    `request_header`  TEXT                               NULL COMMENT '请求头',
    `response_header` TEXT                               NULL COMMENT '响应头',
    `status`          INT      DEFAULT 0                 NOT NULL COMMENT '接口状态（0-关闭，1-开启）',
    `method`          VARCHAR(256)                       NOT NULL COMMENT '请求类型',
    `user_id`         BIGINT                             NOT NULL COMMENT '创建人',
    `create_time`     DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `update_time`     DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`       TINYINT  DEFAULT 0                 NOT NULL COMMENT '是否删除(0-未删, 1-已删)'
) COMMENT '接口信息';

CREATE TABLE IF NOT EXISTS api_credentials_table
(
    id            INT PRIMARY KEY AUTO_INCREMENT COMMENT '凭据ID，主键',
    `user_id`     BIGINT                             NOT NULL COMMENT '用户ID',
    access_key    VARCHAR(255)                       NOT NULL COMMENT '访问密钥，不能为空',
    secret_key    VARCHAR(255)                       NOT NULL COMMENT '密钥，不能为空',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`   TINYINT  DEFAULT 0                 NOT NULL COMMENT '是否删除(0-未删, 1-已删)'
) COMMENT '凭据信息表，存储访问密钥和密钥信息';

CREATE TABLE IF NOT EXISTS api_user_credentials_relation
(
    relation_id   BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '关联关系ID，主键',
    user_id       BIGINT                             NOT NULL COMMENT '用户ID，外键关联到user_table',
    credential_id BIGINT                             NOT NULL COMMENT '凭据ID，外键关联到credentials_table',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`   TINYINT  DEFAULT 0                 NOT NULL COMMENT '是否删除(0-未删, 1-已删)'
) COMMENT '用户与凭据关联表，存储用户与凭据的关联关系';

-- 用户调用接口关系表
CREATE TABLE IF NOT EXISTS `api_user_interface_info`
(
    `id`                BIGINT                             NOT NULL auto_increment COMMENT '主键' PRIMARY KEY,
    `user_id`           BIGINT                             NOT NULL COMMENT '调用用户 id',
    `interface_info_id` BIGINT                             NOT NULL COMMENT '接口 id',
    `total_num`         INT      DEFAULT 0                 NOT NULL COMMENT '总调用次数',
    `left_num`          INT      DEFAULT 0                 NOT NULL COMMENT '剩余调用次数',
    `status`            INT      DEFAULT 0                 NOT NULL COMMENT '0-正常，1-禁用',
    `create_time`       DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `update_time`       DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`         TINYINT  DEFAULT 0                 NOT NULL COMMENT '是否删除(0-未删, 1-已删)'
) COMMENT '用户调用接口关系';

CREATE TABLE IF NOT EXISTS `api_interface_request_info`
(
    `id`             BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`        BIGINT       NOT NULL COMMENT '调用用户 id',
    `interface_path` VARCHAR(255) COMMENT '接口地址',
    `method`         varchar(256) NOT NULL COMMENT '请求类型',
    `describe`       VARCHAR(255) COMMENT '接口描述',
    `status`         INT          NOT NULL DEFAULT '0' COMMENT '0-正常，1-禁用',
    `create_time`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_delete`      INT          NOT NULL DEFAULT '0' COMMENT '是否删除(0-未删, 1-已删)',
    PRIMARY KEY (`id`)
) COMMENT = '接口请求记录';