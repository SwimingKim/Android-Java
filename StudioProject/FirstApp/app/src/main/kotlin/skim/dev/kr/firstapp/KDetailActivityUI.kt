package skim.dev.kr.firstapp

import org.jetbrains.anko.*

/**
 * Created by suyoung on 2018. 2. 25..
 */
class KDetailActivityUI : AnkoComponent<KDetailActivity> {

    override fun createView(ui: AnkoContext<KDetailActivity>) = ui.apply {

        verticalLayout {
            padding = dip(12)

            textView("Enter Login Credentials")

            editText {
                hint = "E-mail"
            }

            editText {
                hint = "Password"
            }

            button("Submit")
        }
    }.view

}