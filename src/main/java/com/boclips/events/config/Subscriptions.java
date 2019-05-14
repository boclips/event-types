package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Subscriptions {

    String SUFFIX = "-subscription";

    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String LEGACY_ORDER_SUBMITTED = TopicNames.LEGACY_ORDER_SUBMITTED + SUFFIX;
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
    String VIDEO_REMOVED_FROM_COLLECTION = TopicNames.VIDEO_REMOVED_FROM_COLLECTION + SUFFIX;
    String VIDEO_ADDED_TO_COLLECTION = TopicNames.VIDEO_ADDED_TO_COLLECTION + SUFFIX;

    @Input(VIDEO_PLAYBACK_SYNC_REQUESTED)
    SubscribableChannel videoPlaybackSyncRequested();

    @Input(VIDEO_ANALYSIS_REQUESTED)
    SubscribableChannel videoAnalysisRequested();

    @Input(VIDEO_INDEXED)
    SubscribableChannel videoIndexed();

    @Input(VIDEO_ANALYSED)
    SubscribableChannel videoAnalysed();

    @Input(LEGACY_ORDER_SUBMITTED)
    SubscribableChannel legacyOrderSubmissions();

    @Input(USER_ACTIVATED)
    SubscribableChannel userActivated();

    @Input(VIDEOS_SEARCHED)
    SubscribableChannel videosSearched();

    @Input(VIDEO_SEGMENT_PLAYED)
    SubscribableChannel videoSegmentPlayed();

    @Input(COLLECTION_AGE_RANGE_CHANGED)
    SubscribableChannel collectionAgeRangeChanged();

    @Input(COLLECTION_BOOKMARKED)
    SubscribableChannel collectionBookmarked();

    @Input(COLLECTION_MADE_PRIVATE)
    SubscribableChannel collectionMadePrivate();

    @Input(COLLECTION_MADE_PUBLIC)
    SubscribableChannel collectionMadePublic();

    @Input(COLLECTION_RENAMED)
    SubscribableChannel collectionRenamed();

    @Input(COLLECTION_SUBJECTS_CHANGED)
    SubscribableChannel collectionSubjectsChanged();

    @Input(COLLECTION_UNBOOKARMED)
    SubscribableChannel collectionUnbookmarked();

    @Input(VIDEO_REMOVED_FROM_COLLECTION)
    SubscribableChannel videoRemovedFromCollection();

    @Input(VIDEO_ADDED_TO_COLLECTION)
    SubscribableChannel videoAddedToCollection();
}
