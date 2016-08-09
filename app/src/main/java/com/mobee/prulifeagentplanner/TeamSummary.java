package com.mobee.prulifeagentplanner;

public class TeamSummary {

    private int m_approachTally;
    private int m_appointmentsTally;
    private int m_presentationTally;
    private int m_closedSaleTally;
    private int m_prospectingTally;
    private int m_totalTally;
    private int m_grandTotal;

    public TeamSummary(){

    }

    public TeamSummary(int approachTally,  int appointmentsTally, int presentationTally
                        , int closedSaleTally ,int prospectingTally, int totalTally, int grandTotal)
    {
        m_approachTally = approachTally;
        m_appointmentsTally = appointmentsTally;
        m_presentationTally = presentationTally;
        m_closedSaleTally = closedSaleTally;
        m_prospectingTally = prospectingTally;
        m_totalTally = totalTally;
        m_grandTotal = grandTotal;
    }

        int getApproachTally()
        {
            return m_approachTally;
        }


        int getAppointmentTally()
        {
            return m_appointmentsTally;
        }

        int getPresentationTally()
        {
            return m_presentationTally;
        }


        int getClosedSaleTally()
        {
            return m_closedSaleTally;
        }


        int getProspectingTally()
        {
            return m_prospectingTally;
        }

        int getTotalTally()
        {
            m_totalTally = getApproachTally() + getAppointmentTally() + getPresentationTally() + getClosedSaleTally() + getProspectingTally();
            return m_totalTally;
        }

        /**
         * Approach 1pt
         * **/
        int getTotalApproach()
        {
            return (getApproachTally() * 1);
        }

        /**
         * Appointment 2pts
         * **/
        int getTotalAppointments()
        {
            return (getAppointmentTally() * 2);
        }

        /**
         * Presentation 3pts
         * **/
        int getTotalPresentation()
        {
            return (getPresentationTally() * 3);
        }

        /**
         * Closed sale 5pts
         * **/
        int getTotalClosedSale()
        {
            return (getClosedSaleTally() * 5);
        }

        /**
         * Prospecting sale 1pt
         * **/
        int getTotalProspects()
        {
            return (getProspectingTally() * 1);
        }

        int getGrandTotal()
        {
            m_grandTotal = getTotalApproach() + getTotalAppointments() + getTotalPresentation() + getTotalClosedSale() + getTotalProspects();
            return m_grandTotal;
        }

        void setApproachTally(int approachTally)
        {
            m_approachTally = approachTally;
        }

        void setAppointmentsTally(int appointmentsTally)
        {
            m_appointmentsTally = appointmentsTally;
        }

        void setPresentationTally(int presentationTally)
        {
            m_presentationTally = presentationTally;
        }

        void setClosedSale(int closedSaleTally)
        {
            m_closedSaleTally = closedSaleTally;
        }

        void setProspectingTally(int prospectingTally)
        {
            m_prospectingTally = prospectingTally;
        }

        void setTotalTally(int totalTally)
        {
            m_totalTally = totalTally;
        }

        void setGrandTotal(int grandTotal)
        {
            m_grandTotal = grandTotal;
        }
}
