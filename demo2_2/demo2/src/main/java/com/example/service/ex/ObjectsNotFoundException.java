package com.example.service.ex;

public class ObjectsNotFoundException extends ServiceException{
    public ObjectsNotFoundException() {
        super();
    }

    public ObjectsNotFoundException(String message) {
        super(message);
    }

    public ObjectsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ObjectsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
