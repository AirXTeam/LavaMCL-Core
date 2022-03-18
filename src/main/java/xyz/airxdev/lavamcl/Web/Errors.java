package xyz.airxdev.lavamcl.Web;

import xyz.airxdev.lavamcl.Tools.B64T;

public class Errors {
    public static String NotFoundError(){
        return "#ERROR\n" + B64T.Encode("NotFound") + "\n#END";
    }
}
