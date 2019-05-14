package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Topics {
    String SUFFIX = "-topic";
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String USER_ACTIVATED = TopicNames.USER_ACTIVATED + SUFFIX;
    String VIDEOS_SEARCHED = TopicNames.VIDEOS_SEARCH + SUFFIX;
    String VIDEO_SEGMENT_PLAYED = TopicNames.VIDEO_SEGMENT_PLAYED + SUFFIX;
    String COLLECTION_AGE_RANGE_CHANGED = TopicNames.COLLECTION_AGE_RANGE_CHANGED + SUFFIX;
    String COLLECTION_BOOKMARKED = TopicNames.COLLECTION_BOOKMARKED + SUFFIX;
    String COLLECTION_MADE_PRIVATE = TopicNames.COLLECTION_MADE_PRIVATE + SUFFIX;
    String COLLECTION_MADE_PUBLIC = TopicNames.COLLECTION_MADE_PUBLIC + SUFFIX;
    String COLLECTION_RENAMED = TopicNames.COLLECTION_RENAMED + SUFFIX;
    String COLLECTION_SUBJECTS_CHANGED = TopicNames.COLLECTION_SUBJECTS_CHANGED + SUFFIX;
    String COLLECTION_UNBOOKARMED = TopicNames.COLLECTION_UNBOOKARMED + SUFFIX;
    String VIDEO_ADDED_TO_COLLECTION = TopicNames.VIDEO_ADDED_TO_COLLECTION + SUFFIX;
    String VIDEO_REMOVED_FROM_COLLECTION = TopicNames.VIDEO_REMOVED_FROM_COLLECTION + SUFFIX;


    @Output(VIDEO_PLAYBACK_SYNC_REQUESTED)
    MessageChannel videoPlaybackSyncRequested();

    @Output(VIDEO_ANALYSIS_REQUESTED)
    MessageChannel videoAnalysisRequested();

    @Output(VIDEO_INDEXED)
    MessageChannel videoIndexed();

    @Output(VIDEO_ANALYSED)
    MessageChannel videoAnalysed();

    @Output(USER_ACTIVATED)
    MessageChannel userActivated();

    @Output(VIDEOS_SEARCHED)
    MessageChannel videosSearched();

    @Output(VIDEO_SEGMENT_PLAYED)
    MessageChannel videoSegmentPlayed();

    @Output(COLLECTION_AGE_RANGE_CHANGED)
    MessageChannel collectionAgeRangeChanged();

    @Output(COLLECTION_BOOKMARKED)
    MessageChannel collectionBookmarked();

    @Output(COLLECTION_MADE_PRIVATE)
    MessageChannel collectionMadePrivate();

    @Output(COLLECTION_MADE_PUBLIC)
    MessageChannel collectionMadePublic();

    @Output(COLLECTION_RENAMED)
    MessageChannel collectionRenamed();

    @Output(COLLECTION_SUBJECTS_CHANGED)
    MessageChannel collectionSubjectsChanged();

    @Output(COLLECTION_UNBOOKARMED)
    MessageChannel collectionUnbookmarked();

    @Output(VIDEO_REMOVED_FROM_COLLECTION)
    MessageChannel videoRemovedFromCollection();

    @Output(VIDEO_ADDED_TO_COLLECTION)
    MessageChannel videoAddedToCollection();
}
