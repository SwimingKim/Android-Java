/**
 * Created by suyoung on 2018. 2. 25..
 */
package skim.dev.kr.firstapp

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class SecondActivity : Activity(), AnkoLogger {

    override val loggerTag: String
        get() = "MyLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager : LinearLayoutManager = LinearLayoutManager(this)
        view.layoutManager = manager

        val adapter : KCityAdapter = KCityAdapter()
        view.adapter = adapter

        val cities = listOf("Seoul", "Tyoko", "Mountaion View", "Singapore")
//        selector(title="Select City", items=cities) { dlg, selection ->
//            toast("You selected ${cities[selection]}")
//        }

//        alert(title="Message", message="Let's learn Kotlin!") {
//            positiveButton("Yes") {
//                toast("Yay!")
//            }
//
//            negativeButton("No") {
//                longToast("No way...")
//            }
//        }.show()

//        val pd = progressDialog(title = "File Download", message = "Downloaing ...")
//        pd.show()
//        pd.progress = 50
//        indeterminateProgressDialog(message="Please wait..").show()

//        val intent = Intent(this.ctx, KDetailActivity::class.java)
//        intent.putExtra("id", 150L)
//        intent.putExtra("title", "Awesome item")
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
//        startActivity(intent)
//        val intent = intentFor<KDetailActivity>(
//                "id" to 150L, "title" to "Awesome item"
//        ).noHistory()
//        startActivity(intent)
        startActivity<KDetailActivity>("id" to 150L, "title" to "Awesome item")
//        sendSMS(number = "01096220213", text = "Hello")

        val dpInPixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, resources.displayMetrics)
        val spInPixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, resources.displayMetrics)
        info(dpInPixel.toString() + "  : " + dip(100))
        info(spInPixel.toString() + "  : " + sp(16).toFloat())

        verbose("??verbose")
        debug("??!!!!!")
        info("????")
        warn("??warn")
        error("??error")
        wtf("??wtf")

    }

}