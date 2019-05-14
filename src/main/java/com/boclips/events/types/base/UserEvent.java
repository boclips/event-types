package com.boclips.events.types.base;

import com.boclips.events.types.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

public interface UserEvent {

    User getUser();
}
