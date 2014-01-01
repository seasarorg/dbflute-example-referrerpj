package com.example.dbflute.bhvap.unit;

import java.sql.Timestamp;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The test base of simple test.
 * @author jflute
 * @since 0.6.0 (2008/01/17 Thursday)
 */
public abstract class PlainTestCase extends TestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(PlainTestCase.class);

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected void log(Object msg) {
        _log.debug(msg);
    }

    protected Date currentDate() {
        return new Date(System.currentTimeMillis());
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected String ln() {
        return "\n";
    }
}
