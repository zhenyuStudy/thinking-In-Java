package structure;

import java.util.List;

class Data{
    private String eventId;
    private String image;
    private String eventName;
}

class Season{
    private String date;
    private List<Data> data;
    private String dateId;

}


public class JsonClass1 {
    private List<Season> season;
}
