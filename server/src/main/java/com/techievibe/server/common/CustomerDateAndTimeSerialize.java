package com.techievibe.server.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomerDateAndTimeSerialize extends JsonSerializer<Date> {

	private static final Logger LOG = LogManager.getLogger(CustomerDateAndTimeSerialize.class);

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException {
		try {
			if (date != null) {
				generator.writeString(dateFormat.format(date));
			}

		} catch (Exception e) {
			LOG.info("CustomerDateAndTimeSerialize >>> : " + e);
		}
	}
}
