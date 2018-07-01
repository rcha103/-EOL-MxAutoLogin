// This file was generated by Mendix Modeler 7.15.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package autologin.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the AutoLogin module
	public static administration.proxies.Account dS_GetAccount(IContext context, java.lang.String _name)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Name", _name);
			IMendixObject result = (IMendixObject)Core.execute(context, "AutoLogin.DS_GetAccount", params);
			return result == null ? null : administration.proxies.Account.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_AutoLoginAccount(IContext context, administration.proxies.Account _account)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Account", _account == null ? null : _account.getMendixObject());
			Core.execute(context, "AutoLogin.SUB_AutoLoginAccount", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static autologin.proxies.LoginTokenHelper sUB_CreateLoginToken(IContext context, administration.proxies.Account _account)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Account", _account == null ? null : _account.getMendixObject());
			IMendixObject result = (IMendixObject)Core.execute(context, "AutoLogin.SUB_CreateLoginToken", params);
			return result == null ? null : autologin.proxies.LoginTokenHelper.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}