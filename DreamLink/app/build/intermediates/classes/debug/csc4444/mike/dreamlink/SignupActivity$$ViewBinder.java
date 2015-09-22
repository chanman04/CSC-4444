// Generated code from Butter Knife. Do not modify!
package csc4444.mike.dreamlink;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SignupActivity$$ViewBinder<T extends csc4444.mike.dreamlink.SignupActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558523, "field 'usernameET'");
    target.usernameET = finder.castView(view, 2131558523, "field 'usernameET'");
    view = finder.findRequiredView(source, 2131558524, "field 'passwordET'");
    target.passwordET = finder.castView(view, 2131558524, "field 'passwordET'");
    view = finder.findRequiredView(source, 2131558525, "field 'emailET'");
    target.emailET = finder.castView(view, 2131558525, "field 'emailET'");
    view = finder.findRequiredView(source, 2131558526, "field 'submitButton'");
    target.submitButton = finder.castView(view, 2131558526, "field 'submitButton'");
    view = finder.findRequiredView(source, 2131558527, "field 'pickLoginTV'");
    target.pickLoginTV = finder.castView(view, 2131558527, "field 'pickLoginTV'");
    view = finder.findRequiredView(source, 2131558528, "field 'loginButton'");
    target.loginButton = finder.castView(view, 2131558528, "field 'loginButton'");
    view = finder.findRequiredView(source, 2131558522, "field 'errorResponseTV'");
    target.errorResponseTV = finder.castView(view, 2131558522, "field 'errorResponseTV'");
  }

  @Override public void unbind(T target) {
    target.usernameET = null;
    target.passwordET = null;
    target.emailET = null;
    target.submitButton = null;
    target.pickLoginTV = null;
    target.loginButton = null;
    target.errorResponseTV = null;
  }
}
