package ph.com.thirtyonedigital.androidboilerplate.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by markcadag on 20/09/2017.
 *
 */

public class DebugUtil {

    private static final String TAG = DebugUtil.class.getSimpleName();

    /**
     * Util for generating hashkey need for facebook settings
     * @param activity
     */
    public static void generateFbHash(Activity activity){
        try {
            PackageInfo info = activity.getPackageManager().getPackageInfo(
                    "ph.com.thirtyonedigital.androidboilerplate", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i(TAG, Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "generateFbHash: ", e );
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e(TAG, "generateFbHash: ", e1 );
        }
    }
}
