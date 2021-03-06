package io.github.feelfreelinux.wykopmobilny.ui.modules.loginscreen

import com.nhaarman.mockito_kotlin.*
import io.github.feelfreelinux.wykopmobilny.utils.api.CredentialsPreferencesApi
import io.github.feelfreelinux.wykopmobilny.utils.usermanager.LoginCredentials
import io.github.feelfreelinux.wykopmobilny.utils.usermanager.UserManagerApi
import org.junit.Before
import org.junit.Test

class LoginScreenPresenterTest {
    lateinit var systemUnderTest: LoginScreenPresenter
    private val mockOfView = mock<LoginScreenView>()
    private val mockOfUserManager = mock<UserManagerApi>()
    private val mockOfApiPreferences = mock<CredentialsPreferencesApi>()

    @Before
    fun setup() {
        systemUnderTest = LoginScreenPresenter(mockOfUserManager)
        systemUnderTest.subscribe(mockOfView)
    }

    @Test
    fun shouldSaveCredentials() {
        val expectedCredentials = LoginCredentials("feuer", "example_token")

        val url = "https://a.wykop.pl/user/ConnectSuccess/appkey/example_key/login/${expectedCredentials.login}/token/${expectedCredentials.token}/"
        systemUnderTest.handleUrl(url)
        verify(mockOfUserManager).loginUser(expectedCredentials)
    }

    @Test
    fun shouldShowErrorOnEmptyUrl() {
        systemUnderTest.handleUrl("")
        verify(mockOfView).showErrorDialog(any())
        verifyNoMoreInteractions(mockOfApiPreferences)
    }

    @Test
    fun shouldExitActivityOnHandle() {
        val url = "https://a.wykop.pl/user/ConnectSuccess/appkey/example_key/login/example_login/token/example_token/"
        systemUnderTest.handleUrl(url)
        verify(mockOfView, times(1)).goBackToSplashScreen()
    }


}