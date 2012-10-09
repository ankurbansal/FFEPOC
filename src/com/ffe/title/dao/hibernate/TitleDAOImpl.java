/**
 * 
 */
package com.ffe.title.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.common.framework.util.ConstantUtil;
import com.ffe.title.dao.TitleDAO;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;




public class TitleDAOImpl extends GenericHibernateDAO<Title> implements
		TitleDAO {

	private static Logger logger = LoggerFactory.getLogger(TitleDAOImpl.class);
	
	
	public JdbcTemplate jdbcTemplate ;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	@Override
	public List<Title> searchTitle(List<SearchCriteria> searchCriteriaList)
			throws GTSException {
		logger.debug("Entering TitleDAOImpl.searchTitle");
		List<Title> Titles = null;
		String firstName = "";
		String lastName = "";
		try {
			Titles = (List<Title>) getSession()
					.createQuery(
							" from com.ffe.title.model.Title Title where upper(firstName) like :firstName or upper(lastName) like :lastName")
					.setParameter("firstName",
							"%" + firstName.toUpperCase() + "%")
					.setParameter("lastName",
							"%" + lastName.toUpperCase() + "%").list();
		} catch (DataAccessException ex) {
			logger.error("Exception in AddressDAOImpl.searchTitle", ex);
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting TitleDAOImpl.searchTitle ");
		
		return Titles;
	}
	
	
	

	
	@Override
	public List<Title> findTitle(String searchString)
			throws GTSException {
		logger.debug(" Entering TitleDAOImpl.findTitle ");
		List<Title> Titles = null;
		try {
			Titles = (List<Title>) getSession()
					.createQuery(
							" select new com.ffe.title.model.Title(p.TitleId,p.sso,p.firstName,p.lastName) "
									+ " from BETitle p where upper(firstName) like :searchString "
									+ " or upper(lastName) like :searchString")
					.setParameter("searchString",
							"%" + searchString.toUpperCase() + "%").list();

		} catch (DataAccessException ex) {
			logger.error("Exception in AddressDAOImpl.findAddress", ex);
			throw new GTSException(ex.getMessage(), ex.getCause());
		} catch (Exception e) {
			logger.error("Exception in AddressDAOImpl.findAddress", e);
			throw new GTSException(e.getMessage(), e.getCause());
		}
		logger.debug(" Exiting TitleDAOImpl.findTitle ");
		return Titles;
	}

	
	public Boolean isTitlePresent(long TitleId, String titleName, String wpr) throws GTSException {
		List<BigDecimal> responseCount = null;
		boolean isPresent=false;
		try {
			
			logger.debug(" Entering TitleDAOImpl.isTitlePresent ");
			String sso="";
			if(!StringUtil.isEmpty(sso)){
			/*Titles = (List<Title>) getSession()
					 .createQuery(
								" select new com.ffe.title.model.Title(p.TitleId,p.sso,p.firstName,p.lastName) "
										+ " from Title  as  p " 
										+" where p.sso = :sso "
										)
						.setParameter("sso",sso).list();*/
			
			responseCount = (List<BigDecimal>) getSession().createSQLQuery("select count(*) from Title where sso_id = :sso " +
					"and Title_id != :TitleId and (deleteflag <> 'Y' or approval_status_id = :deletedUnApproved)")
					.setParameter("TitleId",TitleId)
					.setParameter("sso","")
					.setParameter("deletedUnApproved", ConstantUtil.APPROVAL_STATUS_PENDING_FOR_DELETE)
					.list();
			logger.debug("@responseCount--->"+ responseCount.size());

		}else{
			logger.debug("@firstName--->");
			logger.debug("@lastName--->");
			logger.debug("@emailString--->");
/*				Titles = (List<Title>) getSession()
					 .createQuery(
								" select new com.ffe.title.model.Title(p.TitleId,p.sso,p.firstName,p.lastName) "
										+ " from Title  as  p join p.emails as email" 
										+" where upper(p.firstName) = :firstName " 
										+" and upper(p.lastName)   = :lastName " 
									+" and  upper(email.emailAddress) = :emailAddress "
										)
						.setParameter("firstName",firstName.toUpperCase())
						.setParameter("lastName",lastName.toUpperCase())
						.setParameter("emailAddress",emailString.toUpperCase())
							.list();*/
			
			responseCount = (List<BigDecimal>) getSession().createSQLQuery("select count(*) from Title p,email e " +
					"where p.party_id = e.party_id and Title_id != :TitleId and upper(p.first_name) = :firstName and upper(p.last_name) = :lastName " +
					"and upper(e.email_address) = :email and (p.deleteflag <> 'Y' or p.approval_status_id = :deletedUnApproved)")
					.setParameter("TitleId",TitleId)
//					.setParameter("firstName",firstName.toUpperCase())
//					.setParameter("lastName",lastName.toUpperCase())
//					.setParameter("email", emailString.toUpperCase())
					.setParameter("deletedUnApproved", ConstantUtil.APPROVAL_STATUS_PENDING_FOR_DELETE)
					.list();

			logger.debug("@responseCount--->"+ responseCount.size());

	//logger.info("Titles.size"+ Titles.size());
		}} catch (DataAccessException ex) {
			logger.error("Exception in TitleDAOImpl.isTitlePresent", ex);
			throw new GTSException(ex.getMessage(), ex.getCause());
		} catch (Exception e) {
			
			logger.error("Exception in TitleDAOImpl.isTitlePresent", e);
			throw new GTSException(e.getMessage(), e.getCause());
		}
		
		if(responseCount!= null && responseCount.get(0).intValue() > 0){
			isPresent= true;
		}else{
			isPresent=false;
		}
		logger.debug("@isTitlePresent--->"+ isPresent);
/*		logger.debug("@isTitlePresent--->"+ isPresent);
		logger.info("Value exists or not "+("@isTitlePresent--->"+ isPresent));
		logger.debug(" Exiting TitleDAOImpl.isTitlePresent isPresent---->");*/
		return isPresent;
	}

	@Override
	public boolean deleteTitle(Title Title) throws GTSException {
		// TODO Auto-generated method stub
		
				logger.debug("Entered the deleteTitleID method in DAO");
				boolean response = false;
				/*logger.debug("Title.getLastUpdatedDateTime()"+Title.getLastUpdatedDateTime());
				logger.debug("Title.getLastUpdatedBy()"+Title.getLastUpdatedBy());
				logger.debug("Title.getAddressId()"+Title.getTitleId());*/
				int updateCount = getSession().createSQLQuery("update Title set lastmoddate=:lastmoddate,lastmodby=:lastmodby,deleteflag='Y',approval_status_id = DECODE(POST_APPROVAL_UPDATED,'Y','6','2') ,approved_by=''," +
						"approved_date_time='',COMMENTS=:comments where Title_id =:TitleID")
						.setParameter("lastmoddate", Title.getLastUpdatedDateTime())
						.setParameter("lastmodby", Title.getLastUpdatedBy())
						.setParameter("comments", Title.getComments())
						.setParameter("TitleID", Title.getTitleId())
						.executeUpdate();
				
				updateCount = getSession().createSQLQuery("update party set lastmoddate=:lastmoddate,lastmodby=:lastmodby,deleteflag='Y' " +
						" where party_id =:partyID")
						.setParameter("lastmoddate", Title.getLastUpdatedDateTime())
						.setParameter("lastmodby", Title.getLastUpdatedBy())
						.setParameter("partyID", Title.getTitleId())
						.executeUpdate();
				
				if(updateCount>0)
				{
					response = true;
				}
				else
				{
					response = false;
				}
				logger.debug("End of deleteTitleID method in DAO"+updateCount);
				return response;
	}



	
}
