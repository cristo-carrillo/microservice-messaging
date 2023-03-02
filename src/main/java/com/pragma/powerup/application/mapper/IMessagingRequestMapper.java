package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.MessagingRequestDto;
import com.pragma.powerup.domain.model.MessagingModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMessagingRequestMapper {

    MessagingModel toMessageModel(MessagingRequestDto messagingRequestDto);
}
