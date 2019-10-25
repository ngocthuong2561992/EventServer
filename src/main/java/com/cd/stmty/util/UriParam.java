package com.cd.stmty.util;

public interface UriParam {

    /**
     * URL EVENT
     */

    String EVENT = "/api/v1";

    String LIST_EVENT = "/evt";

    String EVENT_GET_WITH_ID = "/event/{id}";

    String INSERT_EVENT = "/evt";

    String UPDATE_EVENT = "/event/{id}";

    String DELETE_EVENT = "/event/{id}";











    String LIST = "/api/v1/evt";
    String ID = "id";









    String GET = "/{id}";
    String SEARCH = "/search";
    String EVINSERT = "/api/v1/evt";
    String UPDATE = "/update";
    String DELETE = "/delete";
//    String GET_WITH_ID = "/%s";
    String DOWNLOAD = "/download";
    String IMPORT = "/import";
    String READ_CSV = "/read-csv";
    String EXPORT = "/export";
    String IMPORT_FILE = "importFile";
    String DELETE_SET = "/delete-set";
    String SEARCH_KEY = "searchKey";
    String UPLOAD_IMAGE = "/upload-image";
    String DELETE_IMAGE = "/delete-image";
    String KEY_IMAGE = "key";
    String TIME_ZONE = "timeZone";



    /**
     * URL Users
     */
    String USER = "/user";
    String GET_WITH_USER_NAME = "/{displayName}";
}
