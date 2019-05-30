package org.http4k.security.oauth.server

import com.natpryce.get
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.core.ContentType.Companion.APPLICATION_FORM_URLENCODED
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Uri
import org.http4k.core.body.form
import org.http4k.core.with
import org.http4k.lens.Header
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

internal class AccessTokenRequestTest {
    @Test
    fun `grant type=authorization code - can generate request`() {
        val request = Request(Method.POST, "/irrelevant")
            .with(Header.CONTENT_TYPE of APPLICATION_FORM_URLENCODED)
            .form("redirect_uri", "http://some-uri")
            .form("grant_type", "authorization_code")
            .form("code", "some-code")
            .form("client_id", "a-client-id")
            .form("client_secret", "a-client-secret").accessTokenRequest().get()
            as? AuthorizationCodeAccessTokenRequest ?: fail("returned wrong type")

        assertThat(request, equalTo(AuthorizationCodeAccessTokenRequest(
            "authorization_code",
            ClientId("a-client-id"),
            "a-client-secret",
            Uri.of("http://some-uri"),
            AuthorizationCode("some-code")
        )))
    }

    @Test
    fun `grant type=client_credentials - can generate request`() {
        val request = Request(Method.POST, "/irrelevant")
            .with(Header.CONTENT_TYPE of APPLICATION_FORM_URLENCODED)
            .form("grant_type", "client_credentials").accessTokenRequest().get()
            as? ClientCredentialsTokenRequest ?: fail("returned wrong type")

        assertThat(request, equalTo(ClientCredentialsTokenRequest))
    }
}