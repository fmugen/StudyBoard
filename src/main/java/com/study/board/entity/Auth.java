package com.study.board.entity;

public class Auth {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Auth.id
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Auth.username
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Auth.password
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Auth.id
     *
     * @return the value of Auth.id
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Auth.id
     *
     * @param id the value for Auth.id
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Auth.username
     *
     * @return the value of Auth.username
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Auth.username
     *
     * @param username the value for Auth.username
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Auth.password
     *
     * @return the value of Auth.password
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Auth.password
     *
     * @param password the value for Auth.password
     *
     * @mbg.generated Tue Nov 03 16:04:49 JST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}