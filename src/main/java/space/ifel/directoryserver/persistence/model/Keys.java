/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.ifel.directoryserver.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daniel Filho
 */
@Entity
@Table(name = "tbl_Keys", catalog = "FiveDS", schema = "dbo")
@Data
@NoArgsConstructor
public class Keys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "parent_key")
    private String parentKey;
    @Basic(optional = false)
    @Column(name = "rel_name")
    private String relName;
    @Basic(optional = false)
    @Column(name = "is_secured")
    private boolean isSecured;
    @JoinTable(name = "tbl_KeyAncestors", joinColumns = {
        @JoinColumn(name = "ancestor_key", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "key_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Keys> keysList;
    @ManyToMany(mappedBy = "keysList", fetch = FetchType.LAZY)
    private List<Keys> keysList1;

}
