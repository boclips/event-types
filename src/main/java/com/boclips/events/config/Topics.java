package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Topics {
    String SUFFIX = "-topic";
    String VIDEO_UPDATED = TopicNames.VIDEO_UPDATED + SUFFIX;
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String USER_ACTIVATED = TopicNames.USER_ACTIVATED + SUFFIX;
    String VIDEOS_SEARCHED = TopicNames.VIDEOS_SEARCH + SUFFIX;
    String VIDEO_SEGMENT_PLAYED = TopicNames.VIDEO_SEGMENT_PLAYED + SUFFIX;
    String VIDEO_PLAYER_INTERACTED_WITH = TopicNames.VIDEO_PLAYER_INTERACTED_WITH + SUFFIX;
    String COLLECTION_AGE_RANGE_CHANGED = TopicNames.COLLECTION_AGE_RANGE_CHANGED + SUFFIX;
    String COLLECTION_BOOKMARK_CHANGED = TopicNames.COLLECTION_BOOKMARK_CHANGED + SUFFIX;
    String COLLECTION_VISIBILITY_CHANGED = TopicNames.COLLECTION_VISIBILITY_CHANGED + SUFFIX;
    String COLLECTION_RENAMED = TopicNames.COLLECTION_RENAMED + SUFFIX;
    String COLLECTION_SUBJECTS_CHANGED = TopicNames.COLLECTION_SUBJECTS_CHANGED + SUFFIX;
    String VIDEOS_INCLUSION_IN_SEARCH_REQUESTED = TopicNames.VIDEOS_INCLUSION_IN_SEARCH_REQUESTED + SUFFIX;
    String VIDEOS_EXCLUSION_FROM_SEARCH_REQUESTED = TopicNames.VIDEOS_EXCLUSION_FROM_SEARCH_REQUESTED + SUFFIX;
    String VIDEOS_INCLUSION_IN_STREAM_REQUESTED = TopicNames.VIDEOS_INCLUSION_IN_STREAM_REQUESTED + SUFFIX;
    String VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED = TopicNames.VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED + SUFFIX;
    String VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED = TopicNames.VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED + SUFFIX;
    String VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED = TopicNames.VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED + SUFFIX;
    String VIDEO_ADDED_TO_COLLECTION = TopicNames.VIDEO_ADDED_TO_COLLECTION + SUFFIX;
    String VIDEO_REMOVED_FROM_COLLECTION = TopicNames.VIDEO_REMOVED_FROM_COLLECTION + SUFFIX;
    String VIDEO_SUBJECT_CLASSIFICATION_REQUESTED = TopicNames.VIDEO_SUBJECT_CLASSIFICATION_REQUESTED + SUFFIX;
    String VIDEO_SUBJECT_CLASSIFIED = TopicNames.VIDEO_SUBJECT_CLASSIFIED + SUFFIX;
    String VIDEO_CAPTIONS_CREATED = TopicNames.VIDEO_CAPTIONS_CREATED + SUFFIX;
    String VIDEO_TRANSCRIPT_CREATED = TopicNames.VIDEO_TRANSCRIPT_CREATED + SUFFIX;

    @Output(VIDEO_UPDATED)
    MessageChannel videoUpdated();

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

    @Output(VIDEO_PLAYER_INTERACTED_WITH)
    MessageChannel videoPlayerInteractedWith();

    @Output(COLLECTION_AGE_RANGE_CHANGED)
    MessageChannel collectionAgeRangeChanged();

    @Output(COLLECTION_BOOKMARK_CHANGED)
    MessageChannel collectionBookmarkChanged();

    @Output(COLLECTION_VISIBILITY_CHANGED)
    MessageChannel collectionVisibilityChanged();

    @Output(COLLECTION_RENAMED)
    MessageChannel collectionRenamed();

    @Output(COLLECTION_SUBJECTS_CHANGED)
    MessageChannel collectionSubjectsChanged();

    @Output(VIDEOS_INCLUSION_IN_SEARCH_REQUESTED)
    MessageChannel videosInclusionInSearchRequested();

    @Output(VIDEOS_EXCLUSION_FROM_SEARCH_REQUESTED)
    MessageChannel videosExclusionFromSearchRequested();

    @Output(VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED)
    MessageChannel videosInclusionInDownloadRequested();

    @Output(VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED)
    MessageChannel videosExclusionFromDownloadRequested();

    @Output(VIDEOS_INCLUSION_IN_STREAM_REQUESTED)
    MessageChannel videosInclusionInStreamRequested();

    @Output(VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED)
    MessageChannel videosExclusionFromStreamRequested();

    @Output(VIDEO_REMOVED_FROM_COLLECTION)
    MessageChannel videoRemovedFromCollection();

    @Output(VIDEO_ADDED_TO_COLLECTION)
    MessageChannel videoAddedToCollection();

    @Output(VIDEO_SUBJECT_CLASSIFICATION_REQUESTED)
    MessageChannel videoSubjectClassificationRequested();

    @Output(VIDEO_SUBJECT_CLASSIFIED)
    MessageChannel videoSubjectClassified();

    @Output(VIDEO_CAPTIONS_CREATED)
    MessageChannel videoCaptionsCreated();

    @Output(VIDEO_TRANSCRIPT_CREATED)
    MessageChannel videoTranscriptCreated();

    default List<MessageChannel> allTopics() {
        return Arrays.stream(getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(Output.class))
                .map(method -> {
                    try {
                        return (MessageChannel) method.invoke(this);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
