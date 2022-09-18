package domain.cafe;

public enum ErrorMessage {
    NOT_EXIST_MENU_ERROR("존재하지 않는 메뉴입니다.");
    
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
