package http.pg;

public class EchoResponseBody {
    private Args args;

    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

}

class Args {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}