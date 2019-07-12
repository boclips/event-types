package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.boclips.events.config.TopicConstants.*;

public interface Topics {

    @Output(VIDEO_UPDATED + TOPIC_SUFFIX)
    MessageChannel videoUpdated();

    @Output(VIDEO_PLAYBACK_SYNC_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videoPlaybackSyncRequested();

    @Output(VIDEO_ANALYSIS_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videoAnalysisRequested();

    @Output(VIDEO_INDEXED + TOPIC_SUFFIX)
    MessageChannel videoIndexed();

    @Output(VIDEO_ANALYSED + TOPIC_SUFFIX)
    MessageChannel videoAnalysed();

    @Output(USER_ACTIVATED + TOPIC_SUFFIX)
    MessageChannel userActivated();

    @Output(VIDEOS_SEARCHED + TOPIC_SUFFIX)
    MessageChannel videosSearched();

    @Output(VIDEO_SEGMENT_PLAYED + TOPIC_SUFFIX)
    MessageChannel videoSegmentPlayed();

    @Output(VIDEO_PLAYER_INTERACTED_WITH + TOPIC_SUFFIX)
    MessageChannel videoPlayerInteractedWith();

    @Output(COLLECTION_AGE_RANGE_CHANGED + TOPIC_SUFFIX)
    MessageChannel collectionAgeRangeChanged();

    @Output(COLLECTION_BOOKMARK_CHANGED + TOPIC_SUFFIX)
    MessageChannel collectionBookmarkChanged();

    @Output(COLLECTION_VISIBILITY_CHANGED + TOPIC_SUFFIX)
    MessageChannel collectionVisibilityChanged();

    @Output(COLLECTION_RENAMED + TOPIC_SUFFIX)
    MessageChannel collectionRenamed();

    @Output(COLLECTION_SUBJECTS_CHANGED + TOPIC_SUFFIX)
    MessageChannel collectionSubjectsChanged();

    @Output(VIDEOS_INCLUSION_IN_DOWNLOAD_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videosInclusionInDownloadRequested();

    @Output(VIDEOS_EXCLUSION_FROM_DOWNLOAD_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videosExclusionFromDownloadRequested();

    @Output(VIDEOS_INCLUSION_IN_STREAM_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videosInclusionInStreamRequested();

    @Output(VIDEOS_EXCLUSION_FROM_STREAM_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videosExclusionFromStreamRequested();

    @Output(VIDEO_REMOVED_FROM_COLLECTION + TOPIC_SUFFIX)
    MessageChannel videoRemovedFromCollection();

    @Output(VIDEO_ADDED_TO_COLLECTION + TOPIC_SUFFIX)
    MessageChannel videoAddedToCollection();

    @Output(VIDEO_SUBJECT_CLASSIFICATION_REQUESTED + TOPIC_SUFFIX)
    MessageChannel videoSubjectClassificationRequested();

    @Output(VIDEO_SUBJECT_CLASSIFIED + TOPIC_SUFFIX)
    MessageChannel videoSubjectClassified();

    @Output(VIDEO_CAPTIONS_CREATED + TOPIC_SUFFIX)
    MessageChannel videoCaptionsCreated();

    @Output(VIDEO_TRANSCRIPT_CREATED + TOPIC_SUFFIX)
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
