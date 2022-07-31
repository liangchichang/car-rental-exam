package me.lcc.carrent.web;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (credentials == null) {
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId, credentials);
            result.setAuthenticated(false);
            return result;
        }
        String password = credentials.toString();

        BusinessBo businessBo = userService.logIn(userId, password);
        if (!businessBo.isSuccess()) {
            throw new CarRentAuthenticationException(businessBo.getMessage());
        }
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String remoteAddress = details.getRemoteAddress();
        LogInContext.setUserId(userId, remoteAddress);

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId, password);
        result.setDetails(businessBo);
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
