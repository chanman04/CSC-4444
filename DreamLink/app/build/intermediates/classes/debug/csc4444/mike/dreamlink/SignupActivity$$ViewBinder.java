// Generated code from Butter Knife. Do not modify!
package csc4444.mike.dreamlink;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SignupActivity$$ViewBinder<T extends csc4444.mike.dreamlink.SignupActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558512, "field 'usernameET'");
    target.usernameET = finder.castView(view, 2131558512, "field 'usernameET'");
    view = finder.findRequiredView(source, 2131558513, "field 'passwordET'");
    target.passwordET = finder.castView(view, 2131558513, "field 'passwordET'");
    view = finder.findRequiredView(source, 2131558514, "field 'emailET'");
    target.emailET = finder.castView(view, 2131558514, "field 'emailET'");
    view = finder.findRequiredView(source, 2131558515, "field 'submitButton'");
    target.submitButton = finder.castView(view, 2131558515, "field 'submitButton'");
    view = finder.findRequiredView(source, 2131558516, "field 'pickLoginTV'");
    target.pickLoginTV = finder.castView(view, 2131558516, "field 'pickLoginTV'");
    view = finder.findRequiredView(source, 2131558517, "field 'loginButton'");
    target.loginButton = finder.castView(view, 2131558517, "field 'loginButton'");
    view = finder.findRequiredView(source, 2131558511, "field 'errorResponseTV'");
    target.errorResponseTV = finder.castView(view, 2131558511, "field 'errorResponseTV'");
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
