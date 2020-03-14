/*
 * The Continuing Education Tracking System, "CETS," is a professional education
 * tracking application for state and federally licensed individuals who have to
 * complete and document their required continuing education credits ("CEU's")
 * in order to be eligible for periodic license renewal. The application allows
 * users to create their own account and document education courses with an
 * automated sum of hours completed for easy reference. If required by an audit,
 * or to fulfill workplace requirements, the app also support a completed
 * education summary report in a text file.
 */
package cs444continuingeducationtrackingsystem.service;

import java.util.*;
import cs444continuingeducationtrackingsystem.domain.*;

/**
 * Interface for Account Service.
 *
 * @author Nathan Thomas
 * @version 1.0
 */
public interface IAccountSvc {

   public Account create(Account account);

   public List<Account> retrieveAll();

   public Account update(Account account);

   public Account delete(Account account);

   public Account authenticate(Login login);
}
