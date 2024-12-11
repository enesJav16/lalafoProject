package generateId;

public class GenerateId {
    private static Long userId=0L;
    public static Long userId() {
        return ++userId;
    }

    private static Long announcementId=0L;
    public static Long announcementId() {
        return ++announcementId;
    }

    private static Long favoriteId=0L;
    public static Long favoriteId() {
        return ++favoriteId;
    }

}
