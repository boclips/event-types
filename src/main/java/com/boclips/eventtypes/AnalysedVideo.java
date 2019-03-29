package com.boclips.eventtypes;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysedVideo {

    @NonNull
    private String videoId;

    @NonNull
    private String language;

    @NonNull
    private String transcript;

    @NonNull
    private String captions;

    @NonNull
    private List<Assigned<Topic>> topics;

    @NonNull
    private List<Assigned<Keyword>> keywords;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Topic {
        @NonNull
        private String name;

        @NonNull
        private String language;

        private Topic parent;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Assigned<T> {

        @NonNull
        private T value;

        @NonNull
        private Double confidence;

        @NonNull
        private List<TimeSegment> segments;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeSegment {

        @NonNull
        private Integer startSecond;

        @NonNull
        private Integer endSecond;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Keyword {
        @NonNull
        private String name;

        @NonNull
        private String language;
    }
}
