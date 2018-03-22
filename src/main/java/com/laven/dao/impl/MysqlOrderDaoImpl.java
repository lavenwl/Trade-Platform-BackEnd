//package com.laven.dao.impl;
//
//import com.laven.dao.OrderDao;
//import com.laven.entity.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @Description:
// * @Author: laven
// * @Date: 2017/7/2 上午11:09
// */
//@Repository("mysql")
//@Qualifier("mysqlData")
//public class MysqlOrderDaoImpl implements OrderDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private static class OrderRowMapper implements RowMapper<Order> {
//
//        @Override
//        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
//            Order order = new Order();
//            order.setId(resultSet.getInt("id"));
//            order.setDesc(resultSet.getString("desc_laven"));
//            return order;
//        }
//    }
//
//    @Override
//    public Collection<Order> getAllOrder() {
//        List<Order> orderList = jdbcTemplate.query("select id, desc_laven from order_laven", new OrderRowMapper());
//        return orderList;
//    }
//
//    @Override
//    public Order getOrderById(int id) {
//        final String sql = "select id, desc_laven from order_laven where id = ?";
//        Order order = jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
//        return order;
//    }
//
//    @Override
//    public void removeOrderById(int id) {
//        final String sql = "delete from order_laven where id = ?";
//        jdbcTemplate.update(sql, id);
//
//    }
//
//    @Override
//    public void updateOrder(Order order) {
//        final String sql = "update order_laven desc_laven = ? where id = ?";
//        final int id = order.getId();
//        final String desc = order.getDesc();
//        jdbcTemplate.update(sql, new Object[] {desc, id});
//    }
//
//    @Override
//    public void insertOrder(Order order) {
//        final String sql = "insert into order_laven(desc_laven) values(?)";
//        final String desc = order.getDesc();
//        jdbcTemplate.update(sql, new Object[] {desc});
//    }
//}
