package br.com.caelum.vraptor.uploadconfig;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Convert(UploadedFile.class)
public class UploadedFileConverter implements Converter<UploadedFile> {
	private final HttpServletRequest request;

	UploadedFileConverter(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public UploadedFile convert(String value,
			Class<? extends UploadedFile> type, ResourceBundle arg2) {
		Object upload = request.getAttribute(value);
		return type.cast(upload);
	}
}