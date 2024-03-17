# 通用权限校验模块

## 1. 技术栈

### 1.1 前端

| **技术**           | **描述**                                                                          |
|------------------|---------------------------------------------------------------------------------|
| **Vite**         | Vite 是一个由 Vue.js 核心团队维护的下一代前端构建工具，具有快速的冷启动、快速的热更新以及按需编译的特性。                     |
| **Vue3**         | Vue.js 3 是 Vue.js 的最新版本，它提供了许多新的特性和性能优化，例如 Composition API、Teleport、Fragment 等。 |
| **Router**       | Vue Router 是 Vue.js 官方的路由管理器，用于实现单页面应用（SPA）的路由控制和导航管理。                          |
| **Tailwind CSS** | Tailwind CSS 是一个实用的 CSS 框架，提供一组预定义的样式类，通过组合这些类来构建界面，避免手动编写 CSS。                 |
| **DaisyUI**      | DaisyUI 是一个基于 Tailwind CSS 的 UI 框架，提供了一套美观的组件库，可用于快速构建现代化的 Web 应用界面。            |

Front-end Development Document: https://docs.vitejs.dev/

### 1.2后端

| **技术**              | **描述**                                                         |
|---------------------|----------------------------------------------------------------|
| **Spring Boot 2.7** | Spring Boot 是一个基于 Spring 框架的快速开发框架，简化了基于 Spring 的应用程序的初始搭建和开发。 |
| **JDK1.8**          |                                                                |
| **Spring Security** | Spring Security 是 Spring 生态系统中的一个安全框架，用于实现认证、授权、攻击防护等安全相关功能。   |
| **MyBatis-Plus**    | MyBatis-Plus 是 MyBatis 的增强工具包，提供了许多便捷的功能和增强，简化了 MyBatis 的开发过程。 |
| **Redis**           | Redis 是一个基于内存的高性能键值存储数据库，常用于缓存、会话管理、消息队列等场景。                   |
| **MySQL**           | MySQL 是一个流行的开源关系型数据库管理系统，广泛应用于Web开发和其他各种类型的应用程序中。              |

Back-end Development Document: https://docs.vitejs.dev/

### 1.3 Database

1. Table **user**.
    ```SQL
    CREATE TABLE `user`
    (
        `id`           BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
        `user_name`    VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'Username',
        `nick_name`    VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'Nickname',
        `password`     VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'Password',
        `status`       CHAR(1)              DEFAULT '0' COMMENT 'Account Status (0 Active 1 Inactive)',
        `email`        VARCHAR(64)          DEFAULT NULL COMMENT 'Email',
        `phone_number` VARCHAR(32)          DEFAULT NULL COMMENT 'Phone Number',
        `sex`          CHAR(1)              DEFAULT NULL COMMENT 'User Gender (0 Male, 1 Female, 2 Unknown)',
        `avatar`       VARCHAR(128)         DEFAULT NULL COMMENT 'Avatar',
        `user_type`    CHAR(1)     NOT NULL DEFAULT '1' COMMENT 'User Type (0 Administrator, 1 Regular User)',
        `create_by`    BIGINT(20) DEFAULT NULL COMMENT 'Creator User ID',
        `create_time`  DATETIME             DEFAULT NULL COMMENT 'Creation Time',
        `update_by`    BIGINT(20) DEFAULT NULL COMMENT 'Updater',
        `update_time`  DATETIME             DEFAULT NULL COMMENT 'Last Modified Time',
        `del_flag`     INT(11) DEFAULT '0' COMMENT 'Deletion Flag (0 Not Deleted, 1 Deleted)',
        PRIMARY KEY (`id`)
    ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='Users Table'
    ```

2. Table ...

***






