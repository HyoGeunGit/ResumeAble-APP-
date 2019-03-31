package hackathon.hardware.seoul.resumeable


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.gun0912.tedpermission.TedPermissionActivity.startActivity

/**
 * Created by Kinetic on 2018-06-02.
 */

class bleFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ble,
                container,
                false)
        val btn = view.findViewById(R.id.blebtn) as Button
        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View) {
        val intent = Intent(v.context, BlueToothActivity::class.java)
        startActivity(intent)
    }

}
