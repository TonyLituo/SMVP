package com.dhcc.smvp.common.api;

/**
 * Created by Jinx on 2017/5/4.
 */

public interface Api {

    /**
     * LOL测试：http://www.games-cube.com/index.aspx
     * username: lituo
     * password:lituo01
     */

    /**
     * 动态临时Token 每天更新
     */
    String TOKEN = "B28A1-21140-515CA-A1C81";

    /**
     * 基础路径
     */
    String BASE_URL = "http://lolapi.games-cube.com/";

    /**
     * GET路径
     */
    String GET_URL = "Area";
    /**
     * POST路径
     */
    String POST_URL = "";

    /**
     * 文件上传路径
     */
    String UP_FILE_URL = "";

    /**
     * 文件下载基础路径
     */
    String DOWN_FILE_URL = "";
}
