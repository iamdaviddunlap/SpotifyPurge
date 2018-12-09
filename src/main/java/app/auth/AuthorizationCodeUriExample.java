package app.auth;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AuthorizationCodeUriExample {
    private static final String clientId = "4b7e66a9eb4542a0b2d77952badf4478";
    private static final String clientSecret = "a54d101d7331473d9f423096fc70cb2c";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8000/host");

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();
    private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            .state("some-state-of-my-choice")
            .scope("user-modify-playback-state,user-read-playback-state")
            .show_dialog(true)
            .build();

    public static String authorizationCodeUri_Sync() {
        final URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }

    public static void authorizationCodeUri_Async() {
        try {
            final Future<URI> uriFuture = authorizationCodeUriRequest.executeAsync();

            // ...

            final URI uri = uriFuture.get();

            System.out.println("URI: " + uri.toString());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
    }
}