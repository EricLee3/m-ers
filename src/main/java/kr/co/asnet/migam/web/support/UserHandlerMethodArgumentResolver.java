package kr.co.asnet.migam.web.support;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import kr.co.asnet.migam.domain.user.LoginUser;
import kr.co.asnet.migam.domain.user.SessionUser;

/**
 * {@link LoginUser} 어노테이션이 있는 컨트롤러 메소드에 SessionUser 객체를 주입해준다.
 */
public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	@Inject
	private Provider<SessionUser> userProvider;

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
			throws Exception {
		SessionUser sessionUser = userProvider.get();
		return sessionUser;
	}

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.hasParameterAnnotation(LoginUser.class);
	}

}
