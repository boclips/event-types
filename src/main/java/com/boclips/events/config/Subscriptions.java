package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Subscriptions {

    String SUFFIX = "-subscription";

    String VIDEO_UPDATED = TopicNames.VIDEO_UPDATED + SUFFIX;
    interface VideoUpdatedSubscription {
        @Input(VIDEO_UPDATED)
        SubscribableChannel channel();
    }

    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    interface VideoPlaybackSyncRequestedSubscription {
        @Input(VIDEO_PLAYBACK_SYNC_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    interface VideoAnalysisRequestedSubscription {
        @Input(VIDEO_ANALYSIS_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    interface VideoIndexedSubscription {
        @Input(VIDEO_INDEXED)
        SubscribableChannel channel();
    }

    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    interface VideoAnalysedSubscription {
        @Input(VIDEO_ANALYSED)
        SubscribableChannel channel();
    }

    String LEGACY_ORDER_SUBMITTED = TopicNames.LEGACY_ORDER_SUBMITTED + SUFFIX;
    interface LegacyOrderSubmittedSubscription {
        @Input(LEGACY_ORDER_SUBMITTED)
        SubscribableChannel channel();
    }

    String USER_ACTIVATED = TopicNames.USER_ACTIVATED + SUFFIX;
    interface UserActivatedSubscription {
        @Input(USER_ACTIVATED)
        SubscribableChannel channel();
    }

    String VIDEOS_SEARCHED = TopicNames.VIDEOS_SEARCH + SUFFIX;
    interface VideosSearchedSubscription {
        @Input(VIDEOS_SEARCHED)
        SubscribableChannel channel();
    }

    String VIDEO_SEGMENT_PLAYED = TopicNames.VIDEO_SEGMENT_PLAYED + SUFFIX;
    interface VideoSegmentPlayedSubscription {
        @Input(VIDEO_SEGMENT_PLAYED)
        SubscribableChannel channel();
    }

    String VIDEO_PLAYER_INTERACTED_WITH = TopicNames.VIDEO_PLAYER_INTERACTED_WITH + SUFFIX;
    interface VideoPlayerInteractedWithSubscription {
        @Input(VIDEO_PLAYER_INTERACTED_WITH)
        SubscribableChannel channel();
    }

    String COLLECTION_AGE_RANGE_CHANGED = TopicNames.COLLECTION_AGE_RANGE_CHANGED + SUFFIX;
    interface CollectionAgeRangeChangedSubscription {
        @Input(COLLECTION_AGE_RANGE_CHANGED)
        SubscribableChannel channel();
    }

    String COLLECTION_BOOKMARK_CHANGED = TopicNames.COLLECTION_BOOKMARK_CHANGED + SUFFIX;
    interface CollectionBookmarkChangedSubscription {
        @Input(COLLECTION_BOOKMARK_CHANGED)
        SubscribableChannel channel();
    }

    String COLLECTION_VISIBILITY_CHANGED = TopicNames.COLLECTION_VISIBILITY_CHANGED + SUFFIX;
    interface CollectionVisibilityChangedSubscription {
        @Input(COLLECTION_VISIBILITY_CHANGED)
        SubscribableChannel channel();
    }

    String COLLECTION_RENAMED = TopicNames.COLLECTION_RENAMED + SUFFIX;
    interface CollectionRenamedSubscription {
        @Input(COLLECTION_RENAMED)
        SubscribableChannel channel();
    }

    String COLLECTION_SUBJECTS_CHANGED = TopicNames.COLLECTION_SUBJECTS_CHANGED + SUFFIX;
    interface CollectionSubjectsChangedSubscription {
        @Input(COLLECTION_SUBJECTS_CHANGED)
        SubscribableChannel channel();
    }

    String VIDEOS_INCLUSION_IN_STREAM_REQUESTED = TopicNames.VIDEOS_INCLUSION_IN_STREAM_REQUESTED + SUFFIX;
    interface VideosInclusionInStreamRequestedSubscription {
        @Input(VIDEOS_INCLUSION_IN_STREAM_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED = TopicNames.VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED + SUFFIX;
    interface VideosExclusionFromStreamRequestedSubscription {
        @Input(VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED = TopicNames.VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED + SUFFIX;
    interface VideosInclusionInDownloadRequestedSubscription {
        @Input(VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED = TopicNames.VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED + SUFFIX;
    interface VideosExclusionFromDownloadRequestedSubscription {
        @Input(VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEO_REMOVED_FROM_COLLECTION = TopicNames.VIDEO_REMOVED_FROM_COLLECTION + SUFFIX;
    interface VideoRemovedFromCollectionSubscription {
        @Input(VIDEO_REMOVED_FROM_COLLECTION)
        SubscribableChannel channel();
    }

    String VIDEO_ADDED_TO_COLLECTION = TopicNames.VIDEO_ADDED_TO_COLLECTION + SUFFIX;
    interface VideoAddedToCollectionSubscription {
        @Input(VIDEO_ADDED_TO_COLLECTION)
        SubscribableChannel channel();
    }

    String VIDEO_SUBJECT_CLASSIFICATION_REQUESTED = TopicNames.VIDEO_SUBJECT_CLASSIFICATION_REQUESTED + SUFFIX;
    interface VideoSubjectClassificationRequestedSubscription {
        @Input(VIDEO_SUBJECT_CLASSIFICATION_REQUESTED)
        SubscribableChannel channel();
    }

    String VIDEO_SUBJECT_CLASSIFIED = TopicNames.VIDEO_SUBJECT_CLASSIFIED + SUFFIX;
    interface VideoSubjectClassifiedSubscription {
        @Input(VIDEO_SUBJECT_CLASSIFIED)
        SubscribableChannel channel();
    }

    String VIDEO_CAPTIONS_CREATED = TopicNames.VIDEO_CAPTIONS_CREATED + SUFFIX;
    interface VideoCaptionsCreatedSubscription {
        @Input(VIDEO_CAPTIONS_CREATED)
        SubscribableChannel channel();
    }

    String VIDEO_TRANSCRIPT_CREATED = TopicNames.VIDEO_TRANSCRIPT_CREATED + SUFFIX;
    interface VideoTranscriptCreatedSubscription {
        @Input(VIDEO_TRANSCRIPT_CREATED)
        SubscribableChannel channel();
    }
}

