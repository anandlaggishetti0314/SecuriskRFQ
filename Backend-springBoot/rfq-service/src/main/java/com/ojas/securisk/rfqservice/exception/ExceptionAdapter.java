package com.ojas.securisk.rfqservice.exception;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Service;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Service
public class ExceptionAdapter extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

		if (ex instanceof CoveragesNotFoundException) {

			var e = (CoveragesNotFoundException) ex;

			return GraphqlErrorBuilder.newError().errorType(ErrorType.NOT_FOUND).message(e.getMessage())
					.path(env.getExecutionStepInfo().getPath()).location(env.getField().getSourceLocation())
					.extensions(e.getExtensions()).build();

		} else if (ex instanceof CoverageNotFoundException) {

			var e = (CoverageNotFoundException) ex;
			return GraphqlErrorBuilder.newError().errorType(ErrorType.BAD_REQUEST).message(e.getMessage())
					.path(env.getExecutionStepInfo().getPath()).location(env.getField().getSourceLocation()).build();
		}
		return null;
	}

}
