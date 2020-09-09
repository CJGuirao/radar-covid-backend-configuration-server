/*
 * Copyright (c) 2020 Gobierno de España
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package es.gob.radarcovid.configuration.contentful.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.contentful.java.cda.CDAEntry;

import es.gob.radarcovid.configuration.api.KeyValueDto;

@Mapper(componentModel = "spring")
public interface KeyValueMapper {

	KeyValueMapper INSTANCE = Mappers.getMapper(KeyValueMapper.class);
	
	@Mappings(value = {
			@Mapping(target="id", expression="java(source.getField(\"id\"))"),
			@Mapping(target="description", expression="java(source.getField(\"description\"))")
	})
	KeyValueDto entityToDto (CDAEntry source);
	List<KeyValueDto> entityToDto (Collection<CDAEntry> source);

}
